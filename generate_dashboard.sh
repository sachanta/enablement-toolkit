
if [ "$#" -ne 1 ] 
  then
    echo "Not enough arguments supplied, expecting Application Name"
	exit 1;
fi

echo "Generating dashboards for Application '$1'"

dest="target/dashboards"

if [ -e "$dest/$1" ]
then
	echo "'$1' exists in '$dest'. Clearing the contents !"
	rm -rf $dest/$1/*
else
	mkdir $dest/$1
fi

cp Resources/dashboardTemplates/*.json $dest/$1
cd target/dashboards/$1
sed -i -- "s/QuoteandApp_ASM_PS/$1/g" *
echo "Done!"


