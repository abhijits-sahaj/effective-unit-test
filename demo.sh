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

current=0
total=${#COMMITS[@]}

while true; do
  # Safety check: bounds
  if (( current < 0 )); then
    current=0
  elif (( current >= total )); then
    current=$((total - 1))
  fi

  commit="${COMMITS[$current]}"
  echo "Cleaning local changes..."
  git reset --hard > /dev/null
  git clean -fd > /dev/null

  echo "Checking out $commit..."
  git checkout "$commit" > /dev/null

  echo
  echo "Now on commit [$current/$((total-1))]: $commit"
  echo "[n]ext | [p]revious | [q]uit"
  read -p "Choose: " choice

  case "$choice" in
    n|N)
      ((current++))
      ;;
    p|P)
      ((current--))
      ;;
    q|Q)
      echo "Exiting."
      break
      ;;
    *)
      echo "Invalid option. Use n, p, or q."
      ;;
  esac
done
