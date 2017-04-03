#!/usr/bin/env ruby

require 'yaml'
require 'json'

class MyTree
  attr_reader :tree
  attr_accessor :max_per_level

  def initialize(tree)
    @tree = tree
    @max_per_level= []
  end

  def update_max(candidate, level)
    if max_per_level[level].nil?
      @max_per_level[level] = candidate
      return
    end
    current_max = max_per_level[level].keys[0]
    @max_per_level[level] = candidate if current_max < candidate.keys[0]
  end

  def recursive_walk(tree, level)
    nodename, subtree = tree.first # split hash to (k,v)
    value = subtree['value']
    return if value.nil?

    # main action - update max for current level
    update_max({value => nodename}, level)

    # do same for all children
    children_names = subtree.keys.reject { |key| key == 'value' }
    children_names.each do |node|
      recursive_walk({node => subtree[node]}, level+1)
    end
  end

  def find_all_max
    recursive_walk(tree, 0)
    max_per_level
  end
end

def main
#
# Tree: not necessarily 'binary' tree...
#          a=1
#        /     \
#      b=2     c=3
#     /  \ \     \
#  d=4 e=5 f=9   g=8
#   \     \
#   h=2   i=2
#          \
#          j=1
#
# Output [{1:a}, {3:c}, {9:f}, {2:h}, {1:j}]
#
# The level=4 MAX could be either 'h' or 'i' - hash elements are not ordered
#
  tree_yaml = %(---
a:
  value: 1
  b:
    value: 2
    d:
      value: 4
      i:
        value: 2
        j:
          value: 1
    e:
      value: 5
      h:
        value: 2
    f:
      value: 9
  c:
    value: 3
    g:
      value: 9
)
  tree = YAML.load(tree_yaml)
  arr = MyTree.new(tree).find_all_max
  puts
  puts "Source data:"
  puts tree.to_yaml
  puts
  puts "The MAX vaules for each level: #{arr}"
end

main
