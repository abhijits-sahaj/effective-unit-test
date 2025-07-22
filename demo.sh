#!/bin/bash
# demo.sh

COMMITS=(
  checkpoint-0-starting-point  # initial setup
  checkpoint-1-separate-test-case4a8ce61  # added feature A
  checkpoint-2-expect-literals  # refactored method
  checkpoint-3-rename-test-cases  # added tests
  checkpoint-4-inline-setup
  checkpoint-5-remove-setup
  checkpoint-6-use-builders
  checkpoint-7-first-solitary-test
  checkpoint-8-price-solitary-test
  checkpoint-9-move-pricing-to-type
)

for commit in "${COMMITS[@]}"
do
  git checkout "$commit"
  echo "Now on commit $commit"
  read -p "Press enter to continue..."
done