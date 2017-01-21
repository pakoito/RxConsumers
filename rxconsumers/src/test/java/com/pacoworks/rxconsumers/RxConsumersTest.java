/*
 * Copyright (c) pakoito 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.rxconsumers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class RxConsumersTest {
    private int[] sum;

    private ArrayList<Throwable> arrayError;

    @Before
    public void setUp() throws Exception {
        sum = new int[] {
            0
        };
        arrayError = new ArrayList<Throwable>();
    }

    @Test
    public void testWarmup() throws Exception {
        final Consumer<Integer> doOnNext = RxConsumers.act(doAction(sum), doAction(sum), doAction(sum));
        final Consumer<Integer> subscribe = RxConsumers.act(doAction(sum), doAction(sum));
        final Consumer<Throwable> error = RxConsumers.act(doError(arrayError), doError(arrayError), doError(arrayError),
                doError(arrayError), doError(arrayError), doError(arrayError));
        final Action complete = RxConsumers.act(doComplete(sum), doComplete(sum), doComplete(sum), doComplete(sum));
        Observable
                .just(1)
                .doOnNext(doOnNext)
                .subscribe(
                        subscribe,
                        error,
                        complete);
        Assert.assertEquals(9, sum[0]);
        Observable
                .<Integer>error(new RuntimeException("BOOM!"))
                .doOnNext(doOnNext)
                .subscribe(
                        subscribe,
                        error,
                        complete);
        Assert.assertEquals(6, arrayError.size());
    }

    private Action doComplete(final int[] sum) {
        return new Action() {
            @Override
            public void run() {
                sum[0] += 1;
            }
        };
    }

    private Consumer<Integer> doAction(final int[] sum) {
        return new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                sum[0] += 1;
            }
        };
    }

    private Consumer<Throwable> doError(final ArrayList<Throwable> arrayError) {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
                arrayError.add(throwable);
            }
        };
    }
}
