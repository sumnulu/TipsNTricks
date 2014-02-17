package com.fikrimuhal.utils

import java.util.concurrent.DelayQueue
import java.util.concurrent.Delayed
import java.util.concurrent.TimeUnit

import static java.lang.System.currentTimeMillis

/**
 * Created by sumnulu on 06/02/14.
 *
 * @NotThreadSafe
 */
class CallCounter {

    /**
     * Number of operations per Interval allowed
     */
    final private long maxCallAllowedPerInterval

    /**
     * Seconds
     */
    final private long interval


    /**
     * This queue contain operations timestamps in milli seconds
     */
    final private LinkedList<Long> queue

    /**
     *
     * @param interval seconds
     * @param maxCallAllowedPerInterval Number of operations per Interval allowed
     * @param enabled
     */
    CallCounter( long maxCallAllowedPerInterval, long interval, boolean enabled = true) {
        assert interval
        assert maxCallAllowedPerInterval

        this.interval = interval
        this.maxCallAllowedPerInterval = maxCallAllowedPerInterval

        queue = new LinkedList<Long>()
    }

    /**
     * Call this just before operation, if operation allowed true will be returned
     */
    boolean tick() {
        if (isNextCallAllowed()) {
            queue.push(currentTimeMillis())
            return true
        } else {
            return false
        }
    }

    /**
     * 
     * @param number of operations to check, default is 1
     * @return true if next N operation is allowed
     */
    boolean isNextCallAllowed(/*int number = 1*/) {
        cleanTimeOuted()
        return queue.size() < maxCallAllowedPerInterval

    }

    long getCapacityLeft(){
        cleanTimeOuted()
        maxCallAllowedPerInterval - queue.size()
    }

    private cleanTimeOuted() {
        def it = queue.iterator()
        while (it.hasNext()) {

            long elapsed = currentTimeMillis() - it.next()
            if (elapsed > interval * 1000) {
                it.remove()
            } else {
                break
            }

        }

    }


}
