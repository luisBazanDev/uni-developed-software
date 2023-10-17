#!/bin/bash

function how_use {
  echo "$0 file.cpp"
}

if [[ $# -ne 1 ]]
then
  how_use
else
  g++ $1 -o compile.out
  chmod +x compile.out
  ./compile.out
fi