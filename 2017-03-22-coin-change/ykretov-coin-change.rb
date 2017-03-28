#!/usr/bin/env ruby

# Main class - to do the calculations
class MakeChange
  attr_reader :coins, :amount, :debug

  def initialize(coins, amount, debug)
    @coins = coins.sort.uniq.reverse
    @amount = amount
    @debug = debug
  end

  def print_state(n)
    if debug && (n > 0)
      puts "==> amount=#{amount}; coins: #{coins}; combinations: #{n}"
    end
  end

  def print_result
    n = find_all_ways
    puts
    print "Total number of ways to change $#{amount}"
    puts " with coins #{coins} is #{n}"
    puts
  end

  def find_all_ways
    return 0 if coins.count == 0

    if amount == 0
      print_state(1)
      return 1
    end

    max_coin = coins[0] # largest coin we have
    n_cases = amount / max_coin
    if coins.count == 1
      n = (n_cases*max_coin) == amount ? 1 : 0
      print_state(n)
      return n
    end

    new_coins = coins.clone
    new_coins.shift # remove first coin
    n = 0
    0.upto(n_cases).each do |qty|
      new_amount = amount - (max_coin * qty)
      cnt = MakeChange.new(new_coins, new_amount, debug).find_all_ways
      n += cnt
    end
    print_state(n)
    return n
  end
end

def test_results(coins, amount, debug = false)
  MakeChange.new(coins, amount, debug).print_result
end

def main
  test_results([2, 3, 5], 8, true)
  test_results([1, 2, 5, 10], 10, true)
  test_results([1, 2, 5, 10], 15)
  test_results([2, 3, 5], 17)
end

main
