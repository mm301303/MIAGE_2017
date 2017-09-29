#!/bin/bash
#Installator for Entreprise Architect registered edition 
#according to https://www.sparxsystems.com.au/support/faq/enterprise-architect-WINE.html#point1

#Installation of and on wine for debian64

install_path=$(pwd);
echo "installation path : $install_path"
echo '*******************************************************'
echo 'Install Wine and Winetricks'
echo ' '

sudo dpkg --add-architecture i386
sudo add-apt-repository ppa:wine/wine-builds
sudo apt-get update
sudo apt-get install --install-recommends winehq-devel
sudo apt-get install -y winetricks

echo ' '
echo '*******************************************************'
echo 'dependancies : text in diagrams appears as it does in a native Windows installation '
sudo apt-get install -y fonts-crosextra-carlito

echo ' '
echo '*******************************************************'
echo 'Install the MSXML and MDAC components' 

winetricks msxml3
winetricks msxml4
winetricks mdac28

echo '*******************************************************'
echo 'downloading installer'
cd /tmp;
wget http://ea1017:cacieiif@sparxsystems.com/registered/reg_ea_down.html#RegInstaller
wine msiexec /i easetupfull.msi

cd $install_path;

echo '*******************************************************'
echo 'done'
exit 0;
