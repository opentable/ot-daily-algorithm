#!/usr/bin/perl

## Depending on which Perl version you're running you'll get different Unicode semantics
# Perl 5.18 (OSX default) - Unicode 6.2
# Perl 5.24 (Latest, available through homebrew) - Unicode 8.0
# Perl 5.25 (Bleeding edge, available through perlbrew) - Unicode 9.0

## perlbrew allows you to easily install bleeding edge Perl:
# sudo /usr/bin/cpan App::perlbrew
# perlbrew install 5.25.9; perlbrew use 5.25.9

use warnings;
use strict;
use v5.18; # Allow say
use English; # English variable names for readability
use utf8; # Tell perl that our file is utf8
use Unicode::Normalize; # So we can normalize the string

binmode(STDOUT, ":utf8"); # Make sure STDOUT is utf8

# What a "character" is depends entirely on the perceptions of the end user. We'll have to make some assumptions in the code below.
# One thing we do not deal with in this implementation is considering the locale of the end user. For example a Danish user might want AE to be counted as equal to Ä.
sub is_consisting_of_only_unique_characters {
  my $string = $ARG[0];

  # We'll use a hash for checking if a characters has already been seen.
  # Depending on the version of Unicode we're targeting the max amount of keys this could end up storing varies, but should be no more than ~270k if the text contains any assigned codepoint, or ~130k if limited to "graphic characters".
  my %count_for_character;

  # Normalize to pre-composed characters, as \X distinguishes pre-composed and decomposed characters.
  # It's worth noting that this presumes that we want ligatures to be counted as separate from the characters they contain. If we wanted ﬀ to count as if it consisted of literal f's, then we need NFKC normalization instead.
  $string = NFC($string);

  # What a humans considers a character is represented by "extended grapheme clusters" in Unicode, so we need to iterate over these. Fortunately Perl gives us the \X matcher for exactly this purpose.
  while($string =~ /\X/g) {
    if($count_for_character{$MATCH}) {
      return 0;
    }
    $count_for_character{$MATCH}++;
  }

  return 1;
}

my $string1 = "ÅÄÖ\x{41}\x{308}";
my $string2 = "👨‍❤️‍💋‍👨\x{1F469}\x{200D}\x{2764}\x{FE0F}\x{200D}\x{1F48B}\x{200D}\x{1F469}";
my $string3 = "🇸🇪🏳️‍🌈";
my $string4 = "ﬀ f";

say is_consisting_of_only_unique_characters($string1) ? "$string1\t is unique" : "$string1\t is not unique";
say is_consisting_of_only_unique_characters($string2) ? "$string2\t is unique" : "$string2\t is not unique";
say is_consisting_of_only_unique_characters($string3) ? "$string3\t is unique" : "$string3\t is not unique";
say is_consisting_of_only_unique_characters($string4) ? "$string4\t is unique" : "$string4\t is not unique";

## Perl 5.24 and earlier:
# ÅÄÖÄ   is not unique
# 👨‍❤️‍💋‍👨👩‍❤️‍💋‍👩   is not unique
# 🇸🇪🏳️‍🌈   is unique
# ﬀ f   is unique

## Perl 5.25 and later:
# ÅÄÖÄ   is not unique
# 👨‍❤️‍💋‍👨👩‍❤️‍💋‍👩   is unique
# 🇸🇪🏳️‍🌈   is unique
# ﬀ f   is unique
