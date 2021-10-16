#Check if PR contains 500 lines
warn("Big PR") if git.lines_of_code > 500

# Add analytics checkstyle
checkstyle_format.base_path = Dir.pwd
checkstyle_format.gradle_task = "ktlint --reporter=plain --reporter=checkstyle,output=ktlint-report-in-checkstyle-format.xml"
checkstyle_format.report "ktlint-report-in-checkstyle-format.xml"

# Add detekt
kotlin_detekt.severity = "warning"
kotlin_detekt.gradle_task = "detektVerification"
kotlin_detekt.report_file = "app/build/reports/detekt/detekt-checkstyle.xml"
kotlin_detekt.detekt(inline_mode: true)

# Jacoco
#jacoco.minimum_project_coverage_percentage = 1 # default 0
#jacoco.minimum_class_coverage_percentage = 1 # default 0
jacoco.files_extension = [".java", "kt"]
jacoco.report('app/build/reports/jacoco/codeCoverageReport/codeCoverageReport.xml', "http://jacoco-html-reports/")
