#!/usr/bin/env bash
set -e

if [[ $EUID -ne 0 ]]; then
	echo "Run this script as root!"
	exit 1
fi

baseDir=$(dirname "$0")
repositoryDir=$(realpath ${baseDir})/repository
sourcesListFile=/etc/apt/sources.list.d/debian-package-demo.list

if [[ -f ${sourcesListFile} ]]; then
	echo "Sources list $sourcesListFile exists!"
else
	echo "deb [trusted=yes] file:///${repositoryDir} ./" > ${sourcesListFile}
	echo "Sources list added. Don't forget to run 'sudo apt update'"
fi

