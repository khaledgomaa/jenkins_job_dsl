job('DotNet dsl_example') {
    scm {
        git('https://github.com/khaledgomaa/aspjenkinspipeline.git') {  node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('khaledgomaa670@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('dotnetbuilder') // this is the name of the Dotnet installation in 
                         // Manage Jenkins -> Configure Tools -> Dotnet Installations -> Name
    }
    steps {
        shell("dotnet build")
    }
}
