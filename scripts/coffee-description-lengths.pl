use strict;
use warnings FATAL => 'all';
use v5.28;
use JSON 'from_json';

my $coffee_path = 'src/main/resources/data/coffee-data.json';
my $coffee_str = do { local $/; open my $fh, "<$coffee_path"; <$fh> };
my $coffee = from_json $coffee_str;

for my $c (@$coffee) {
    say "description: ", length($c->{description});
}

