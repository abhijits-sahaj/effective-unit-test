#!/bin/bash
# demo.sh

COMMITS=(
  checkpoint-0-starting-point  # initial setup
  checkpoint-1-separate-test-case  # added feature A
  checkpoint-2-expect-literals  # refactored method
  checkpoint-3-rename-test-cases  # added tests
  checkpoint-4-inline-setup
  checkpoint-5-remove-setup
  checkpoint-6-use-builders
  checkpoint-7-first-solitary-test
  checkpoint-8-price-solitary-test
  checkpoint-9-move-pricing-to-type
  checkpoint-10-customer-test-mocks
  fa3ada0
)

for commit in "${COMMITS[@]}"
do
  git checkout "$commit"
  echo "Now on commit $commit"
  read -p "Press enter to continue..."
done