//comment, a comment here or there
env.VERSION = 'blahdeblah'
properties([parameters([extendedChoice(description: '', multiSelectDelimiter: ',', name: 'myChoice', propertyFile: 'pipe-choice/XYZ.properties', propertyKey: 'appName', quoteValue: false, saveJSONParameterToFile: false, type: 'PT_SINGLE_SELECT', visibleItemCount: 5)])])
node {
    checkout scm
    if[[ -n env.VERSION ]];then
       sh '''
         git checkout ${env.VERSION}
       '''
    echo "Our choice ${myChoice}"
}
