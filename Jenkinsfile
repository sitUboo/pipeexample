//comment, a comment here or there
properties([parameters([extendedChoice(description: '', multiSelectDelimiter: ',', name: 'myChoice', propertyFile: 'pipe-choice/XYZ.properties', propertyKey: 'appName', quoteValue: false, saveJSONParameterToFile: false, type: 'PT_SINGLE_SELECT', visibleItemCount: 5)])])
node {
    checkout scm
    echo "Our choice ${myChoice}"
}
