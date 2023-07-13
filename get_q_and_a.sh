#!/bin/bash

# invoke this script to download the Q&A for all your courses
# you have to provide two parameters:
# 1 - your Udemy instructor API token
# 2 - the path where you want to save the data on your computer
# example invocation: get_q_and_a.sh [YOUR_TOKEN] /home/sara/Downloads

java -jar QA.jar path=/home/sal/Downloads/ token=$1

courses=$(awk -F';' '{if (NR!=1) {print $1}}' courses.csv)

for c in $courses
do
  java -jar QA.jar path=$2 token=$1 course=$c
done

