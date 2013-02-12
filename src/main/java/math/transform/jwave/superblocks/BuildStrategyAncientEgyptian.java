/**
 * JWave
 *
 * Copyright 2010-2013 Christian Scheiblich
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 *
 * This file BuildStrategyAncientEgyptian.java is part of JWave.
 *
 * @author Christian Scheiblich
 * contact graetz@mailfish.de
 * date Feb 11, 2013 3:10:33 PM
 *
 */
package math.transform.jwave.superblocks;

import math.transform.jwave.exc.JWaveException;
import math.transform.jwave.superblocks.exc.SuperBlockException;
import math.transform.jwave.tools.AncientEgyptianMultiplication;


/**
 * @author Christian Scheiblich
 * date Feb 11, 2013 3:10:33 PM
 *
 */
public class BuildStrategyAncientEgyptian extends BuildStrategy {
  
  private AncientEgyptianMultiplication _ancientEgyptianMultiplication;
  
  /**
   * @author Christian Scheiblich
   * date Feb 11, 2013 3:10:33 PM
   *
   * @param noUnkowns
   * @throws JWaveException
   */
  public BuildStrategyAncientEgyptian( int noUnkowns ) throws JWaveException {
    
    super( noUnkowns );
    
    _noRows = noUnkowns;
    
    _noCols = noUnkowns;
  
    _ancientEgyptianMultiplication = new AncientEgyptianMultiplication( );
    
  }

  @Override
  public int[ ] generateRowDecomposition( ) throws SuperBlockException {
    
    int[ ] rowDecomposition = null;
   
    try {
      
      rowDecomposition = _ancientEgyptianMultiplication.decompose( _noRows );
          
      for( int i = 0; i < rowDecomposition.length; i++ )
        rowDecomposition[ i ] = (int)_ancientEgyptianMultiplication.scalb( 1., rowDecomposition[ i ] );
    
    } catch( JWaveException e ) {

      throw new SuperBlockException( e.getMessage( ) );
      
    }
    
    return rowDecomposition;
    
  }

  @Override
  public int[ ] generateColDecomposition( )  throws SuperBlockException {
    
    int[ ] colDecomposition = null;
    
    try {
      
      colDecomposition = _ancientEgyptianMultiplication.decompose( _noCols );
      
      for( int j = 0; j < colDecomposition.length; j++ )
        colDecomposition[ j ] = (int)_ancientEgyptianMultiplication.scalb( 1., colDecomposition[ j ] );    
      
    } catch( JWaveException e ) {

      throw new SuperBlockException( e.getMessage( ) );
      
    }
    
    return colDecomposition;
  }
  
}
