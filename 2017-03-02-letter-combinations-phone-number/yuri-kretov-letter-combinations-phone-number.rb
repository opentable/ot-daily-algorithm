class PhoneMapping
  attr_reader :orig_data, :normalized_data
  attr_reader :page_size
  attr_reader :max_pages, :pages_counter

  MAX_PAGE = 1000

  PHONE_MAPPING = {
    '0' => [],
    '1' => [],
    '2' => %w(a b c),
    '3' => %w(d e f),
    '4' => %w(g h i),
    '5' => %w(j k l),
    '6' => %w(m n o),
    '7' => %w(p q r s),
    '8' => %w(t u v),
    '9' => %w(w x y z)
  }

  def strip_phone_number(str)
    s = str.gsub(/[^\d]/, '')  # remove all non-digits
    s.gsub(/[01]/, '')   # on the other hand... no need for zeros and ones
  end

  def initialize(orig_data, page_size = 1, max_pages = 0)
    @orig_data = orig_data
    @normalized_data = strip_phone_number(orig_data)
    @page_size = [[page_size.abs, 1].max, MAX_PAGE].min
    @max_pages = max_pages.abs
    @pages_counter = 0
  end

  def get_next_page
    newpage = []
    recursive_walk(normalized_data) do |result|
      break if result == ''

      newpage.push(result)
      if newpage.length >= page_size
        yield page_size > 1 ? newpage : newpage[0]
        newpage = []
        @pages_counter += 1
        break if (pages_counter >= max_pages) && (max_pages != 0)
      end
    end
    yield newpage # partial or empty
  end

  def recursive_walk(phone_number)
    len = phone_number.to_s.length
    if len == 0
      yield ''
    else
      last_digit = phone_number[-1, 1]
      recursive_walk(phone_number[0, len-1]) do |sub_result|
        PHONE_MAPPING[last_digit].each do |sym|
          yield sub_result + sym
        end
      end
    end
  end
end

class PhoneMappingDemo < PhoneMapping
  def print_results
    puts
    puts "Original data: '#{orig_data}'"
    puts "Normalized data (digits only; excluding 0-s and 1-s): '#{normalized_data}'"
    puts "Page size: #{page_size}"
    print "Max pages: #{max_pages}"
    print " (no limit)" if max_pages == 0
    puts
    puts
    puts "~~~ Results found ~~~"
    puts

    counter = 1
    get_next_page do |page|
      break if page == [] || page == ''
      puts "==> Page \##{counter}: #{page}"
      counter += 1
    end
    puts
    puts "~~~ The end ~~~"
    puts
  end
end

def test1
  puts 'Test 1'
  PhoneMappingDemo.new('1').print_results
end

def test2
  puts 'Test 2'
  PhoneMappingDemo.new('22').print_results
end

def test3
  puts 'Test 3'
  PhoneMappingDemo.new('7', 3).print_results
end

def test4
  puts 'Test 4'
  PhoneMappingDemo.new('667', 4).print_results
end

def test5
  # will try a number for  '1-800-OPENTABLE'
  ot_number = 'OPENTABLE 1(800)673-6822#53'
  puts 'Test 5'
  PhoneMappingDemo.new(ot_number, 3, 10).print_results
end

def test6
  # will try a number for  '1-800-OPENTABLE'
  ot_number = 'OPENTABLE 673682253'
  puts "Test 6 - break when match a string 'opentable' for source '#{ot_number}'"
  start = Time.now
  puts "Start time = #{start}"
  counter = 0
  PhoneMapping.new(ot_number).get_next_page do |result|
    counter += 1
    if result == 'opentable'
      puts "Found a match (result \# #{counter})!!! Exiting..."
      break
    end
  end
  finish = Time.now
  puts "Finish time = #{finish}"
  puts "Total time spent: #{finish - start} seconds"
  puts
end

def main()
  test1
  test2
  test3
  test4
  test5
  test6
end

main()
