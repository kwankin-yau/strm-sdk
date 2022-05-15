package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class StrmStatSampling {
        private long min;
        private long max;
        private double mean;
        private double p50;
        private double p75;
        private double p95;

        public StrmStatSampling() {
        }

        public StrmStatSampling(long min, long max, double mean, double p50, double p75, double p95) {
            this.min = min;
            this.max = max;
            this.mean = mean;
            this.p50 = p50;
            this.p75 = p75;
            this.p95 = p95;
        }

        public long getMin() {
            return min;
        }

        public void setMin(long min) {
            this.min = min;
        }

        public long getMax() {
            return max;
        }

        public void setMax(long max) {
            this.max = max;
        }

        public double getMean() {
            return mean;
        }

        public void setMean(double mean) {
            this.mean = mean;
        }

        public double getP50() {
            return p50;
        }

        public void setP50(double p50) {
            this.p50 = p50;
        }

        public double getP75() {
            return p75;
        }

        public void setP75(double p75) {
            this.p75 = p75;
        }

        public double getP95() {
            return p95;
        }

        public void setP95(double p95) {
            this.p95 = p95;
        }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmStatSampling.class.getSimpleName() + "[", "]")
                .add("min=" + min)
                .add("max=" + max)
                .add("mean=" + mean)
                .add("p50=" + p50)
                .add("p75=" + p75)
                .add("p95=" + p95)
                .toString();
    }
}

