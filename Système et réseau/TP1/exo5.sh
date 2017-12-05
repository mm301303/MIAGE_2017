#!/bin/bash

#on supprime le repertoire s'il existe
rm -rf Sys;

#on cree Sys
mkdir Sys;

cd ./Sys;

numero=0;

while test $numero != 5
    do 
    # la commande "touch" permet de créer un fichier vide :
    touch fichier"$numero";
    line=0;
	while test $line != 14
	    do 
	    echo "$line " >> fichier"$numero";
	    line=$(($line + 1));
	    if test $numero -eq 2
    		then echo "système <- il est la !" >> fichier"$numero";
    	fi
	done
	numero=$(($numero + 1));
done

pwd;

grep -r -i -l 'système' ./ 




