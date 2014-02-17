package com.fikrimuhal.utils;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sumnulu on 06/02/14.
 */
public class CallCounterTest {
    CallCounter cc
    /**
     * 1 second for 300 calls
     */
    final INTERVAL = 1
    final CAPACITY = 200


    @Before
    public void setUp() throws Exception {
        cc = new CallCounter(CAPACITY, INTERVAL)
    }

    @Test
    void empty() {
        assert cc.enabled
        assert cc.isNextCallAllowed()

        assert cc.capacityLeft == CAPACITY
    }

    @Test
    void testOneTick() {
        assert cc.tick()
        assert cc.isNextCallAllowed()
        assert cc.capacityLeft == CAPACITY - 1
    }

    @Test
    void testUnderLimit() {
        100.times {
            assert cc.tick(),'there should be at least 99 call left'
        }
        assert cc.capacityLeft == CAPACITY - 100, 'there should be at least 99 call left'

        50.times {
            assert cc.tick(), 'should be true'
        }
        assert cc.isNextCallAllowed() , 'Should be true, we are at the limit'

    }

    @Test
    void testEdgeUnderLimit() {
        200.times {
            assert cc.tick()
        }
        assert cc.capacityLeft == 0
        assert !cc.isNextCallAllowed()

    }

    @Test
    void testEdgeOverLimit() {
        200.times {
            assert cc.tick()
        }
        assert !cc.isNextCallAllowed()
        assert !cc.tick()

        assert cc.capacityLeft == 0

    }

    @Test
    void testTimeout() {
        200.times {
            assert cc.tick()
        }
        assert !cc.isNextCallAllowed()
        assert !cc.tick()
        assert cc.capacityLeft == 0

        sleep(INTERVAL * 1000)


        assert cc.capacityLeft == CAPACITY

    }

    @Test
    void testHalfTimeout() {
        50.times {
            assert cc.tick()
        }

        assert cc.capacityLeft == CAPACITY-50

        sleep(500)

        assert cc.capacityLeft == CAPACITY-50
        50.times {
            assert cc.tick()
        }
        assert cc.capacityLeft == CAPACITY-100

        sleep(500) //

        assert cc.capacityLeft == CAPACITY - 50

    }

}
