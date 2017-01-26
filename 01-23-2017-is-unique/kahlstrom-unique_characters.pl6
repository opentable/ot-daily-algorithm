#!/usr/bin/perl6

# Install Rakudo Star Perl 6 with homebrew: brew install rakudo-star

sub is_consisting_of_only_unique_characters($supplied_string) {
  # Make sure we convert our string to NFC
  my $string = $supplied_string.NFC.Str;

  # Perl6 uses Extended Grapheme clusters internally (called NFG), but at this point they only seem to be surfaced with .chars and .substr. Doesn't seem to be a way to split into EGC's
  for ^($string.chars-1) -> $index {
    my $character = $string.substr($index, 1);
    if $string.substr($index+1..Inf).index($character) {
      return 0;
    }
  }

  return 1;
}

my $string1 = “नि👩‍❤️‍💋‍👨ÅÄÖ \c[LATIN CAPITAL LETTER A]\c[COMBINING DIAERESIS]”;
my $string2 = “👨‍❤️‍💋‍👨 \c[WOMAN]\c[ZERO WIDTH JOINER]\c[HEAVY BLACK HEART]\c[VARIATION SELECTOR-16]\c[ZERO WIDTH JOINER]\c[KISS MARK]\c[ZERO WIDTH JOINER]\c[WOMAN]”; # Incorrectly marked as not unique as Rakudo Star has not yet included support for Emoji 4.0
my $string3 = “🇸🇪🏳️‍🌈”;
my $string4 = “ﬀ f”;

say is_consisting_of_only_unique_characters($string1)
  ?? “$string1\t is unique”
  !! “$string1\t is not unique”;

say is_consisting_of_only_unique_characters($string2)
  ?? “$string2\t is unique”
  !! “$string2\t is not unique”;

say is_consisting_of_only_unique_characters($string3)
  ?? “$string3\t is unique”
  !! “$string3\t is not unique”;

say is_consisting_of_only_unique_characters($string4)
  ?? “$string4\t is unique”
  !! “$string4\t is not unique”;
