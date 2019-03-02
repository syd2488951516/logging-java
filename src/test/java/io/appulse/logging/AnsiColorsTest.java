/*
 * Copyright 2019 the original author or authors.
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
 */

package io.appulse.logging;

import static io.appulse.logging.AnsiColor.BLACK;
import static io.appulse.logging.AnsiColor.BLUE;
import static io.appulse.logging.AnsiColor.BRIGHT_BLACK;
import static io.appulse.logging.AnsiColor.BRIGHT_BLUE;
import static io.appulse.logging.AnsiColor.BRIGHT_CYAN;
import static io.appulse.logging.AnsiColor.BRIGHT_GREEN;
import static io.appulse.logging.AnsiColor.BRIGHT_MAGENTA;
import static io.appulse.logging.AnsiColor.BRIGHT_RED;
import static io.appulse.logging.AnsiColor.BRIGHT_WHITE;
import static io.appulse.logging.AnsiColor.BRIGHT_YELLOW;
import static io.appulse.logging.AnsiColor.CYAN;
import static io.appulse.logging.AnsiColor.GREEN;
import static io.appulse.logging.AnsiColor.MAGENTA;
import static io.appulse.logging.AnsiColor.RED;
import static io.appulse.logging.AnsiColor.WHITE;
import static io.appulse.logging.AnsiColor.YELLOW;
import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

/**
 * Tests for {@link AnsiColors}.
 *
 * @since 1.0.0
 * @author Artem Labazin
 */
public class AnsiColorsTest {

  @Test
  public void getClosestWhenExactMatchShouldReturnAnsiColor () {
    assertEquals(getClosest(0x000000), BLACK);
    assertEquals(getClosest(0xAA0000), RED);
    assertEquals(getClosest(0x00AA00), GREEN);
    assertEquals(getClosest(0xAA5500), YELLOW);
    assertEquals(getClosest(0x0000AA), BLUE);
    assertEquals(getClosest(0xAA00AA), MAGENTA);
    assertEquals(getClosest(0x00AAAA), CYAN);
    assertEquals(getClosest(0xAAAAAA), WHITE);
    assertEquals(getClosest(0x555555), BRIGHT_BLACK);
    assertEquals(getClosest(0xFF5555), BRIGHT_RED);
    assertEquals(getClosest(0x55FF00), BRIGHT_GREEN);
    assertEquals(getClosest(0xFFFF55), BRIGHT_YELLOW);
    assertEquals(getClosest(0x5555FF), BRIGHT_BLUE);
    assertEquals(getClosest(0xFF55FF), BRIGHT_MAGENTA);
    assertEquals(getClosest(0x55FFFF), BRIGHT_CYAN);
    assertEquals(getClosest(0xFFFFFF), BRIGHT_WHITE);
  }

  @Test
  public void getClosestWhenCloseShouldReturnAnsiColor () {
    assertEquals(getClosest(0x292424), BLACK);
    assertEquals(getClosest(0x8C1919), RED);
    assertEquals(getClosest(0x0BA10B), GREEN);
    assertEquals(getClosest(0xB55F09), YELLOW);
    assertEquals(getClosest(0x0B0BA1), BLUE);
    assertEquals(getClosest(0xA312A3), MAGENTA);
    assertEquals(getClosest(0x0BB5B5), CYAN);
    assertEquals(getClosest(0xBAB6B6), WHITE);
    assertEquals(getClosest(0x615A5A), BRIGHT_BLACK);
    assertEquals(getClosest(0xF23333), BRIGHT_RED);
    assertEquals(getClosest(0x55E80C), BRIGHT_GREEN);
    assertEquals(getClosest(0xF5F54C), BRIGHT_YELLOW);
    assertEquals(getClosest(0x5656F0), BRIGHT_BLUE);
    assertEquals(getClosest(0xFA50FA), BRIGHT_MAGENTA);
    assertEquals(getClosest(0x56F5F5), BRIGHT_CYAN);
    assertEquals(getClosest(0xEDF5F5), BRIGHT_WHITE);
  }

  private AnsiColor getClosest (int rgb) {
    return AnsiColors.getClosest(new Color(rgb));
  }
}
