#!/bin/bash

rm run.pid
rm outputs.log
rm erros.log
nohup ./run.sh>outputs.log 2>errors.log&echo $!> run.pid
