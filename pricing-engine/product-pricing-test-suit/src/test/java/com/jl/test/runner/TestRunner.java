package com.jl.test.runner;

import java.text.SimpleDateFormat;
import java.util.List;

import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.gherkin.GherkinStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.PrintStreamStepdocReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.SilentStepMonitor;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.reeda.springbootjbehave.LiveTestApp;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LiveTestApp.class)
public class TestRunner extends JUnitStories {

    public TestRunner() {
        initJBehaveConfiguration();
    }

    private void initJBehaveConfiguration() {
        Class<?> thisClass = this.getClass();
        useConfiguration(new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(thisClass.getClassLoader()))
                .usePendingStepStrategy(new FailingUponPendingStep())
                .useStepdocReporter(new PrintStreamStepdocReporter())
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(thisClass))
                        .withDefaultFormats()
                        .withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML, Format.STATS)
                        .withCrossReference(new CrossReference())
                        .withFailureTrace(true))
                .useParameterConverters(new ParameterConverters()
                        .addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd"))))
                .useStoryParser(new GherkinStoryParser())
                .useStepMonitor(new SilentStepMonitor()));
    }

    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), "**/*.story", "**/excluded*.story");
    }

}
