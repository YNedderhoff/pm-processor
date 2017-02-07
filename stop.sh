#!/bin/bash

echo "Shutting down pm-processor ..." >> logs/pm-processor.log
pkill -f 'java.*pm-processor.*jar'