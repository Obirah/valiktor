/*
 * Copyright 2018-2020 https://www.valiktor.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.valiktor.functions

import org.valiktor.Validator
import org.valiktor.constraints.Equals
import org.valiktor.constraints.Greater
import org.valiktor.constraints.GreaterOrEqual
import org.valiktor.constraints.IntegerDigits
import org.valiktor.constraints.Less
import org.valiktor.constraints.LessOrEqual
import org.valiktor.constraints.NotEquals

/**
 * Validates if the [Long] property is equal to zero
 *
 * @receiver the property to be validated
 * @return the same receiver validator
 */
fun <E> Validator<E>.ReceiverValidator<E, Long?>.isZero(): Validator<E>.ReceiverValidator<E, Long?> =
    this.validate(Equals(0L)) { it == null || it == 0L }

/**
 * Validates if the [Long] property is not equal to zero
 *
 * @receiver the property to be validated
 * @return the same receiver validator
 */
fun <E> Validator<E>.ReceiverValidator<E, Long?>.isNotZero(): Validator<E>.ReceiverValidator<E, Long?> =
    this.validate(NotEquals(0L)) { it == null || it != 0L }

/**
 * Validates if the [Long] property is equal to one
 *
 * @receiver the property to be validated
 * @return the same receiver validator
 */
fun <E> Validator<E>.ReceiverValidator<E, Long?>.isOne(): Validator<E>.ReceiverValidator<E, Long?> =
    this.validate(Equals(1L)) { it == null || it == 1L }

/**
 * Validates if the [Long] property is not equal to one
 *
 * @receiver the property to be validated
 * @return the same receiver validator
 */
fun <E> Validator<E>.ReceiverValidator<E, Long?>.isNotOne(): Validator<E>.ReceiverValidator<E, Long?> =
    this.validate(NotEquals(1L)) { it == null || it != 1L }

/**
 * Validates if the [Long] property is positive
 *
 * @receiver the property to be validated
 * @return the same receiver validator
 */
fun <E> Validator<E>.ReceiverValidator<E, Long?>.isPositive(): Validator<E>.ReceiverValidator<E, Long?> =
    this.validate(Greater(0L)) { it == null || it > 0L }

/**
 * Validates if the [Long] property isn't negative
 *
 * @receiver the property to be validated
 * @return the same receiver validator
 */
fun <E> Validator<E>.ReceiverValidator<E, Long?>.isPositiveOrZero(): Validator<E>.ReceiverValidator<E, Long?> =
    this.validate(GreaterOrEqual(0L)) { it == null || it >= 0L }

/**
 * Validates if the [Long] property is negative
 *
 * @receiver the property to be validated
 * @return the same receiver validator
 */
fun <E> Validator<E>.ReceiverValidator<E, Long?>.isNegative(): Validator<E>.ReceiverValidator<E, Long?> =
    this.validate(Less(0L)) { it == null || it < 0L }

/**
 * Validates if the [Long] property isn't positive
 *
 * @receiver the property to be validated
 * @return the same receiver validator
 */
fun <E> Validator<E>.ReceiverValidator<E, Long?>.isNegativeOrZero(): Validator<E>.ReceiverValidator<E, Long?> =
    this.validate(LessOrEqual(0L)) { it == null || it <= 0L }

/**
 * Validates if the [Long] property digits is within the limits (min and max)
 *
 * @property min specifies the minimum size
 * @property max specifies the maximum size
 *
 * @receiver the property to be validated
 * @return the same receiver validator
 */
fun <E> Validator<E>.ReceiverValidator<E, Long?>.hasDigits(min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE): Validator<E>.ReceiverValidator<E, Long?> =
    this.validate(IntegerDigits(min, max)) { it == null || it.toString().removePrefix("-").length in min.rangeTo(max) }
