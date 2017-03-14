package com.theironyard;

import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.matcher.RegexMatcher;
import net.doughughes.testifier.test.TestifierTest;
import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class MainTest extends TestifierTest{

    @Test
    public void testMainPrintsThreeLinesOfText() {
        /* arrange */

        /* act */
        Main.main(null);
        List<String> printed = outputWatcher.getLines();

        /* assert */
        assertThat("The main() method should have printed three lines of text",
                printed.size(), equalTo(3));
    }

    @Test
    public void testPrintedLinesContainANumberOfDaysUntil() {
        /* arrange */

        /* act */
        Main.main(null);
        List<String> printed = outputWatcher.getLines();

        /* assert */
        assertThat("Line 1 of output should contain the number of days until a date. EG: '123 days'",
                printed.get(0), RegexMatcher.matches("^.*?[0-9]+ days.*?$"));
        assertThat("Line 2 of output should contain the number of days until a date. EG: '123 days'",
                printed.get(1), RegexMatcher.matches("^.*?[0-9]+ days.*?$"));
        assertThat("Line 3 of output should contain the number of days until a date. EG: '123 days'",
                printed.get(2), RegexMatcher.matches("^.*?[0-9]+ days.*?$"));
    }

    @Test
    public void testPrintedLinesContainValidDateFormat() {
        /* arrange */

        /* act */
        Main.main(null);
        List<String> printed = outputWatcher.getLines();

        /* assert */
        assertThat("Line 1 of output should contain a date in the format month/day/year. EG: 1/1/2017",
                printed.get(0), RegexMatcher.matches("^.*?[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}.*?$"));
        assertThat("Line 2 of output should contain a date in the format month/day/year. EG: 1/1/2017",
                printed.get(1), RegexMatcher.matches("^.*?[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}.*?$"));
        assertThat("Line 3 of output should contain a date in the format month/day/year. EG: 1/1/2017",
                printed.get(2), RegexMatcher.matches("^.*?[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}.*?$"));
    }

    @Test
    public void testNewDateTimeFormatterCreated() {
        /* arrange */

        /* act */
        String code = null;
        try {
            code = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            e.printStackTrace();
        }

        /* assert */
        assertThat("The main() method should create DateTimeFormatter variable using ofPattern().",
                code, RegexMatcher.matches("^.*?VariableDeclarationExpr.*?ClassOrInterfaceType\\[DateTimeFormatter\\].*?NameExpr\\[DateTimeFormatter\\].*?MethodName\\[ofPattern\\].*?\\/MethodCallExpr .*?$"));

    }

    @Test
    public void testInvokesDaysTo() {
        /* arrange */

        /* act */
        String code = "";
        try {
            code = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            e.printStackTrace();
        }

        // how many uses of daysTo() do we have?

        Matcher matcher = Pattern.compile("NameExpr\\[SignificantDate\\] MethodName\\[daysTo\\]").matcher(code);
        int count = 0;
        while(matcher.find()) count++;

        /* assert */
        assertThat("The main() method should call the SignificantDate's daysTo() method at least three times, one for each date printed.",
                count, greaterThanOrEqualTo(3));

    }

    @Test
    public void testInvokesFormat() {
        /* arrange */

        /* act */
        String code = "";
        try {
            code = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            e.printStackTrace();
        }

        // how many uses of daysTo() do we have?
        Matcher matcher = Pattern.compile("NameExpr\\[formatter\\] MethodName\\[format\\]").matcher(code);
        int count = 0;
        while(matcher.find()) count++;

        /* assert */
        assertThat("The main() method should call the formatter's format() method at least three times, one for each date printed.",
                count, greaterThanOrEqualTo(3));

    }

    @Test
    public void testInvokesNext() {
        /* arrange */

        /* act */
        String code = "";
        try {
            code = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            e.printStackTrace();
        }

        // how many uses of daysTo() do we have?
        Matcher matcher = Pattern.compile("NameExpr\\[SignificantDate\\] MethodName\\[next\\]").matcher(code);
        int count = 0;
        while(matcher.find()) count++;

        /* assert */
        assertThat("The main() method should call the SignificantDate's next() method at least three times, one for each date printed.",
                count, greaterThanOrEqualTo(3));

    }

    @Test
    public void testAccessesSignificantDateFields() {
        /* arrange */

        /* act */
        String code = "";
        try {
            code = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            e.printStackTrace();
        }

        // how many uses of daysTo() do we have?
        Matcher matcher = Pattern.compile("NameExpr\\[SignificantDate\\] FieldAccessExpr").matcher(code);
        int count = 0;
        while(matcher.find()) count++;

        /* assert */
        assertThat("The main() method should read at least two of the SignificantDate's static properties.",
                count, greaterThanOrEqualTo(2));
    }

    @Test
    public void testCreatesMonthDayOf() {
        /* arrange */

        /* act */
        String code = "";
        try {
            code = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            e.printStackTrace();
        }

        // how many uses of daysTo() do we have?
        Matcher matcher = Pattern.compile("NameExpr\\[MonthDay\\] MethodName\\[of\\]").matcher(code);
        int count = 0;
        while(matcher.find()) count++;

        /* assert */
        assertThat("The main() method should use MonthDay's of() method to create a new arbitrary MonthDay.",
                count, greaterThanOrEqualTo(1));
    }





}