# Detekt Model Application
This is a model application to showcase the capabilities of the EasyADL Detekt plugin.

It uses an implementation of the MVC architecture pattern to do this.

The EasyADL architecture description can be found in the [archDescription.eadl](archDescription.eadl) file.

This project has two branches, that show the capabilities of the EasyADL Detekt plugin.

## Master branch

The `master` branch shows an implementation of the MVC architecture without any architectural flaws or issues.

When running the `detektMain` Gradle task, the Detekt report, as well as the architecture report generated by the
EasyADL Detekt plugin will not show any issues. The architecture report will show that all components, defined in the
architecture description, are correctly found in the source code by the EasyADL Detekt plugin.

## Flawed Implementation

The `flawedImplementation` branch shows an implementation of the MVC architecture that has architectural flaws.

When running the `detektMain` Gradle task, the Detekt report, as well as the architecture report generated by the
EasyADL Detekt plugin will show two issues: A `View` component not referencing the `Controller` component and a
`Controller` component not referencing a `Model` component.

## Setup

It is required to first build the [EasyADL project](https://github.com/Tommyten/easyAdlDetektPlugin) and publish
it to a local Maven repository, so that the EasyADL Detekt and Gradle plugins become available to this project.