<?php
/**
 * Copyright (C) 2015 Derek J. Lambert
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

namespace CrEOF\Geo\WKT;

use Doctrine\Common\Lexer\AbstractLexer;

/**
 * Convert spatial value to tokens
 *
 * @author  Derek J. Lambert <dlambert@dereklambert.com>
 * @license http://dlambert.mit-license.org MIT
 */
class Lexer extends AbstractLexer
{
    const T_NONE               = 1;
    const T_INTEGER            = 2;
    const T_STRING             = 3;
    const T_E                  = 4;
    const T_FLOAT              = 5;
    const T_CLOSE_PARENTHESIS  = 6;
    const T_OPEN_PARENTHESIS   = 7;
    const T_COMMA              = 8;
    const T_DOT                = 10;
    const T_EQUALS             = 11;
    const T_MINUS              = 14;
    const T_SEMICOLON          = 50;
    const T_SRID               = 500;

    // Geometry types > 600
    const T_TYPE               = 600;
    const T_POINT              = 601;
    const T_LINESTRING         = 602;
    const T_POLYGON            = 603;
    const T_MULTIPOINT         = 604;
    const T_MULTILINESTRING    = 605;
    const T_MULTIPOLYGON       = 606;
    const T_GEOMETRYCOLLECTION = 607;

    /**
     * @param string $input a query string
     */
    public function __construct($input)
    {
        $this->setInput($input);
    }

    /**
     * @param string $value
     *
     * @return int
     */
    protected function getType(&$value)
    {
        switch (true) {
            case (is_numeric($value)):
                if (strpos($value, '.') !== false) {
                    $value = (float) $value;

                    return self::T_FLOAT;
                }

                $value = (int) $value;

                return self::T_INTEGER;
            case (strtoupper($value) === 'E'):
                return self::T_E;
            case (ctype_alpha($value)):
                $name = __CLASS__ . '::T_' . strtoupper($value);

                if (defined($name)) {
                    return constant($name);
                }

                return self::T_STRING;
            case ($value === ','):
                return self::T_COMMA;
            case ($value === '('):
                return self::T_OPEN_PARENTHESIS;
            case ($value === ')'):
                return self::T_CLOSE_PARENTHESIS;
            case ($value === '='):
                return self::T_EQUALS;
            case ($value === ';'):
                return self::T_SEMICOLON;
            default:
                return self::T_NONE;
        }
    }

    /**
     * @return string[]
     */
    protected function getCatchablePatterns()
    {
        return array(
            '[a-z]*',
            '(?:[+-]?[0-9]+)(?:[\.][0-9]+)?'
        );
    }

    /**
     * @return string[]
     */
    protected function getNonCatchablePatterns()
    {
        return array('\s+');
    }
}
