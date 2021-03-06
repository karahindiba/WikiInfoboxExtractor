package crf.features;

import cc.mallet.pipe.Pipe;

import java.io.PrintWriter;

/***
 * A factory pattern for decoupling feature engineering from classifier
 * implementation
 * @author Delip Rao
 *
 */

public abstract class FeatureFactory {
  


  /**
   * Build features
   */
  public abstract void build();
  
  /**
   * 
   * @return a pipe for the feature factory
   */
  public abstract Pipe getPipe();
  
  /**
   * dumpCopy of the features for debugging
   * @param outputStream
   */
  public abstract void setFeatureDumpStream(PrintWriter outputStream);
  
  @SuppressWarnings("unchecked")
  public static final FeatureFactory loadFeatureFactory(String featureFactoryString) throws Exception {
    Class featureFactoryClass = Class.forName(featureFactoryString);
    Object featureFactoryInstance = featureFactoryClass.newInstance();
    if(featureFactoryInstance instanceof FeatureFactory) {
      FeatureFactory factory =  (FeatureFactory)featureFactoryInstance;

      return factory;
    }
    throw new Exception("Loaded object is not a feature factory!");
  }


}
