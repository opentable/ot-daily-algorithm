#!/usr/bin/env ruby

# Main class - to do the calculations
class MakeChange
  attr_reader :coins, :amount
  attr_accessor :counter, :coins_set

  def initialize(coins, amount)
    @coins = coins.sort.uniq
    @amount = amount
    @counter = 0
    @coins_set = init_coins_set(coins)
  end

  def init_coins_set(coins)
    zeros = Array.new(coins.length, 0)
    Hash[coins.zip(zeros)]
  end

  def callback_when_found
    @counter += 1
  end

  def find_all_ways
    sum = coins_set.inject(0) { |sum, (coin, qty)| sum + (coin*qty) }
    callback_when_found if sum == amount

  end

  def ways_to_change
    find_all_ways
    counter
  end
end

# Auxiliary class - to print out test results
class MakeChangeTest < MakeChange
  attr_reader :debug

  CURRENCY_SYMBOL = '$'

  def initialize(coins, amount, debug = false)
    super(coins, amount)
    @debug = debug
    print_current_state if debug
  end

  def print_current_state
    puts "DEBUG: coins=#{coins}"
    puts "DEBUG: amount=#{amount}"
    puts "DEBUG: counter=#{counter}"
    puts "DEBUG: coins_set=#{coins_set}"
  end

  def print_combination
    print "DEBUG: found #{counter}-th way to split #{CURRENCY_SYMBOL}#{amount}: "
    change_split = coins_set.map do |coin, count|
      "(#{CURRENCY_SYMBOL}#{coin} x #{count})"
    end.join(" + ")
    puts change_split
  end

  def print_result
    n = ways_to_change
    puts
    print "Total number of ways to change #{CURRENCY_SYMBOL}#{amount}"
    puts " with coins #{coins} is #{n}"
  end

  def callback_when_found
    super
    print_combination if debug
  end
end

def test_results(coins, amount, debug = false)
  test_change = MakeChangeTest.new(coins, amount, debug)
  test_change.print_result
end

def main
  test_results([1, 2, 5, 10], 7, true)
  # test_results([1, 2, 5, 10], 10)
  # test_results([1, 2, 5, 10], 50)
end

main
