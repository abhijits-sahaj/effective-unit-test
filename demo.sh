#!/bin/bash
# demo.sh

COMMITS=(
  3d55db8  # initial setup
  4a8ce61  # added feature A
  647d006  # refactored method
  deaab7e  # added tests
)

for commit in "${COMMITS[@]}"
do
  git checkout "$commit"
  echo "Now on commit $commit"
  read -p "Press enter to continue..."
done