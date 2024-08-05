package com.izeye.helloworld.api;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.II_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;
import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE_INTERESTING;

/**
 * Sample from https://github.com/openjdk/jcstress/blob/master/jcstress-samples/src/main/java/org/openjdk/jcstress/samples/api/API_01_Simple.java.
 *
 * @author Johnny Lim
 */
@JCStressTest
@Outcome(id = "1, 1", expect = ACCEPTABLE_INTERESTING, desc = "Both actors came up with the same value: atomicity failure.")
@Outcome(id = "1, 2", expect = ACCEPTABLE, desc = "actor1 incremented, then actor2.")
@Outcome(id = "2, 1", expect = ACCEPTABLE, desc = "actor2 incremented, then actor1.")
@State
public class API_01_Simple {

    int v;

    @Actor
    public void actor1(II_Result r) {
        r.r1 = ++v;
    }

    @Actor
    public void actor2(II_Result r) {
        r.r2 = ++v;
    }

}
