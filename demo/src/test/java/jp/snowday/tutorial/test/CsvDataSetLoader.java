package jp.snowday.tutorial.test;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvURLDataSet;
import org.springframework.core.io.Resource;

import java.util.stream.Stream;

public class CsvDataSetLoader extends AbstractDataSetLoader {
    /**
     * Factory method used to create the {@link IDataSet dataset}
     *
     * @param resource an existing resource that contains the dataset data
     * @return a dataset
     * @throws Exception if the dataset could not be loaded
     */
    @Override
    protected IDataSet createDataSet(Resource resource) throws Exception {
        return new CsvURLDataSet(resource.getURL());
    }

    /**
     * Get the resource locations that should be considered when attempting to load a dataset from the specified
     * location.
     *
     * @param testClass The class under test
     * @param location  The source location
     * @return an array of potential resource locations
     */
    @Override
    protected String[] getResourceLocations(Class<?> testClass, String location) {
        return  new String[] { "classpath:xml/" + convertClass2Path(testClass) + location };
    }

    private String convertClass2Path(Class<?> testClass) {
        StringBuilder sb = new StringBuilder();
        String[] rst = testClass.getName().split("\\.");
        Stream.of(rst)
                .skip(4)
                .forEach(s -> sb.append(s).append("/"));

        return sb.toString();
    }
}
