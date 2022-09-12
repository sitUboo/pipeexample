//comment, a comment here or there
env.VERSION = 'blahdeblah'
properties([parameters([extendedChoice(description: '', multiSelectDelimiter: ',', name: 'myChoice', propertyFile: 'pipe-choice/XYZ.properties', propertyKey: 'appName', quoteValue: false, saveJSONParameterToFile: false, type: 'PT_SINGLE_SELECT', visibleItemCount: 5)])])
node {
    checkout scm
     sh '''
        if [ -n env.VERSION ]
        then
            git checkout ${env.VERSION}
        fi
       '''
    echo "Our choice ${myChoice}"
}
