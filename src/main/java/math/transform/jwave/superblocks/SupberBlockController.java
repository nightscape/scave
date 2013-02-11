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
 * This file SupberBlockController.java is part of JWave.
 *
 * @author Christian Scheiblich
 * contact graetz@mailfish.de
 * date 08.02.2013 06:54:39
 *
 */
package math.transform.jwave.superblocks;

import math.transform.jwave.superblocks.types.BlockType;

/**
 * Class for building a SuperBlock object as a representation of a matrix.
 * This can be done by an empty SuperBlock, by a SuperBlock keeping already
 * DummyBlock objects, or by a SuperBlock keeping already memory occupying
 * BlockFull or BlockIndex objects. Building philosophy is given by a set
 * size of each block. However, a rest of number of unknowns is handled by
 * the Ancient Egyptian Multiplication, setting up squeezed and stretched
 * Block objects.
 * 
 * @author Christian Scheiblich
 * date 08.02.2013 06:54:39
 *
 */
public class SupberBlockController {
  
  /**
   * @author Christian Scheiblich
   * date 08.02.2013 06:54:39
   *
   */
  public SupberBlockController( ) {
  }
  
  public void createSuperBlock( BuildPhilosophy buildPhilosophy, BlockType blockType ) {
    
  }
  
}
