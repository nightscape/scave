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
 * This file BuildPhilosophy.java is part of JWave.
 *
 * @author Christian Scheiblich
 * contact graetz@mailfish.de
 * date 08.02.2013 07:02:54
 *
 */
package math.transform.jwave.superblocks;

import java.util.ArrayList;
import math.transform.jwave.exc.JWaveException;
import math.transform.jwave.exc.JWaveFailure;

/**
 * Class for different philosophies of building up a SuperBlocks by
 * differently sized Block objects.
 * 
 * @author Christian Scheiblich
 * date 08.02.2013 07:02:54
 *
 */
public abstract class BuildPhilosophy {
  
  /**
   * The size of a squared matrix is actually the number of rows or
   * the number of columns.
   * 
   * @author Christian Scheiblich
   * date 08.02.2013 07:06:31
   *
   */
  protected int _size;
  
  /**
   * Number of rows of the matrix.
   * 
   * @author Christian Scheiblich
   * date 08.02.2013 07:06:53
   *
   */
  protected int _noRows;
  
  /**
   * Number of columns of the matrix.
   * 
   * @author Christian Scheiblich
   * date 08.02.2013 07:07:07
   *
   */
  protected int _noCols;
  
  /**
   * An array keeping the off set numbers for splitting the total
   * number of rows into several parts that are chosen by the
   * selected build philosophy.
   * 
   * @author Christian Scheiblich
   * date Feb 11, 2013 12:42:46 PM
   *
   */
  protected ArrayList< Integer > _arrSplitRows2Parts;
  
  /**
   * An array keeping the off set numbers for splitting the total
   * number of rows into several parts that are chosen by the
   * selected build philosophy.
   * 
   * @author Christian Scheiblich
   * date Feb 11, 2013 12:44:02 PM
   *
   */
  protected ArrayList< Integer > _arrSplitCols2Parts;  
  
  /**
   * Standard Constructor building it up.
   * 
   * @author Christian Scheiblich
   * date 08.02.2013 07:07:42
   *
   */
  protected BuildPhilosophy( int noUnkowns ) throws JWaveException {
    
    if( noUnkowns < 1 )
      throw new JWaveFailure( "number of unkowns is smaller than 1 unkown - not possible" );
    
    _size = noUnkowns;
    
    _arrSplitRows2Parts = null; // set to null, due to not knowing if and how those are used
    
    _arrSplitCols2Parts = null; // set to null, due to not knowing if and how those are used
    
  }
  
}
