#!/bin/bash

#entry point to salamr
script_dir="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
java -jar "$script_dir/jar/salamr-1.1.jar" "$1" "$2"
