package me.bpulse.domain.proto.kpi;

import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRQ.HistogramQuantitiesRQ;
import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRS.HistogramQuantitiesRS;
import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRQ.Condition;
import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRQ.Range;
import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRQ.WhereCondition;
import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRS.Interval;
import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRS.Quantities;
import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRS.QuantityDay;
import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRS.QuantityHour;
import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRS.QuantityMinute;
import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRS.QuantityMonth;
import me.bpulse.domain.proto.histogram.HistogramQuantitiesMessageRS.QuantityYear;

import org.junit.Test;

import com.googlecode.protobuf.format.JsonFormat;

public class HistogramMessageTest {

	@Test
	public void testNewInstanceRQ() {
		HistogramQuantitiesRQ.Builder rqBuilder = HistogramQuantitiesRQ
				.newBuilder();

		WhereCondition.Builder wcBuil = WhereCondition.newBuilder();
		Range.Builder range = Range.newBuilder();
		range.setGte(1);
		range.setLte(20);
		wcBuil.setTimeRange(range);

		Condition.Builder condition = Condition.newBuilder();
		condition.setAttName("clientId");
		condition.setValue("ACME");
		wcBuil.addConditions(condition);
		rqBuilder.setWhereCondition(wcBuil);

		HistogramQuantitiesRQ rq = rqBuilder.build();
		String jsonFormat = JsonFormat.printToString(rq);
		System.out.println(jsonFormat);
	}

	@Test
	public void testNewInstanceRS() {
		HistogramQuantitiesRS.Builder rsBuilder = HistogramQuantitiesRS
				.newBuilder();
		rsBuilder.setId("KIP-ID");
		rsBuilder.setRsTime(200);
		rsBuilder.setShortName("Nombre Corto");

		for (int a = 1; a < 3; a++) {
			Quantities.Builder quantities = Quantities.newBuilder();
			Interval.Builder interval = Interval.newBuilder();
			interval.setGte(a - 1);
			interval.setLt(a);

			quantities.setInterval(interval);

			for (int z = 0; z < 2; z++) {
				QuantityYear.Builder yBuild = QuantityYear.newBuilder();
				yBuild.setY(2010 + z);
				yBuild.setQ(322000);
				yBuild.setPCT(10.8f);

				QuantityMonth.Builder month = null;
				for (int i = 1; i < 2; i++) {

					month = QuantityMonth.newBuilder();
					month.setM(i);
					month.setQ(3300);
					month.setPCT(10.8f);

					QuantityDay.Builder day = null;
					for (int j = 1; j < 2; j++) {
						day = QuantityDay.newBuilder();
						day.setD(j);
						day.setQ(1501);
						day.setPCT(10.8f);

						QuantityHour.Builder hour = null;
						for (int k = 1; k < 2; k++) {
							hour = QuantityHour.newBuilder();
							hour.setH(k);
							hour.setQ(122);
							hour.setPCT(10.8f);

							QuantityMinute.Builder minute = null;
							for (int l = 0; l < 3; l++) {
								minute = QuantityMinute.newBuilder();
								minute.setMi(l);
								minute.setQ(12);
								minute.setPCT(10.8f);

								hour.addMts(minute);
							}
							day.addHs(hour);
						}
						month.addDs(day);
					}
					yBuild.addMs(month);
				}

				quantities.addYs(yBuild);
			}

			rsBuilder.addQuantities(quantities);
		}

		String jsonFormat = JsonFormat.printToString(rsBuilder.build());
		System.out.println(jsonFormat);
	}
}
