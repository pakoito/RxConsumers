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

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public final class RxConsumers {
    public RxConsumers() {
        // No instances
    }

    public static <T> Consumer<T> act(final Consumer<T> action1, final Consumer<T> action2) {
        return new Consumer<T>() {
            @Override
            public void accept(T t) throws Exception {
                action1.accept(t);
                action2.accept(t);
            }
        };
    }

    public static <T> Consumer<T> act(final Consumer<T> action1, final Consumer<T> action2,
            final Consumer<T> action3) {
        return new Consumer<T>() {
            @Override
            public void accept(T t) throws Exception {
                action1.accept(t);
                action2.accept(t);
                action3.accept(t);
            }
        };
    }

    public static <T> Consumer<T> act(final Consumer<T> action1, final Consumer<T> action2,
            final Consumer<T> action3, final Consumer<T> action4) {
        return new Consumer<T>() {
            @Override
            public void accept(T t) throws Exception {
                action1.accept(t);
                action2.accept(t);
                action3.accept(t);
                action4.accept(t);
            }
        };
    }

    public static <T> Consumer<T> act(final Consumer<T> action1, final Consumer<T> action2,
            final Consumer<T> action3, final Consumer<T> action4, final Consumer<T> action5) {
        return new Consumer<T>() {
            @Override
            public void accept(T t) throws Exception {
                action1.accept(t);
                action2.accept(t);
                action3.accept(t);
                action4.accept(t);
                action5.accept(t);
            }
        };
    }

    public static <T> Consumer<T> act(final Consumer<T>... actions) {
        return new Consumer<T>() {
            @Override
            public void accept(T t) throws Exception {
                for (Consumer<T> action : actions) {
                    action.accept(t);
                }
            }
        };
    }

    public static Action act(final Action action1, final Action action2) {
        return new Action() {
            @Override
            public void run() throws Exception {
                action1.run();
                action2.run();
            }
        };
    }

    public static Action act(final Action action1, final Action action2, final Action action3) {
        return new Action() {
            @Override
            public void run() throws Exception {
                action1.run();
                action2.run();
                action3.run();
            }
        };
    }

    public static Action act(final Action action1, final Action action2, final Action action3,
            final Action action4) {
        return new Action() {
            @Override
            public void run() throws Exception {
                action1.run();
                action2.run();
                action3.run();
                action4.run();
            }
        };
    }

    public static Action act(final Action action1, final Action action2, final Action action3,
            final Action action4, final Action action5) {
        return new Action() {
            @Override
            public void run() throws Exception {
                action1.run();
                action2.run();
                action3.run();
                action4.run();
                action5.run();
            }
        };
    }

    public static Action act(final Action... actions) {
        return new Action() {
            @Override
            public void run() throws Exception {
                for (Action action : actions) {
                    action.run();
                }
            }
        };
    }
}
