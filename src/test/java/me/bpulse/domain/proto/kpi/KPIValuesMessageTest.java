package me.bpulse.domain.proto.kpi;

import me.bpulse.domain.proto.kpi.KPIValuesMessageRQ.Condition;
import me.bpulse.domain.proto.kpi.KPIValuesMessageRQ.KPIValuesRQ;
import me.bpulse.domain.proto.kpi.KPIValuesMessageRQ.Range;
import me.bpulse.domain.proto.kpi.KPIValuesMessageRQ.WhereCondition;
import me.bpulse.domain.proto.kpi.KPIValuesMessageRS.KPIValueDay;
import me.bpulse.domain.proto.kpi.KPIValuesMessageRS.KPIValueHour;
import me.bpulse.domain.proto.kpi.KPIValuesMessageRS.KPIValueMinute;
import me.bpulse.domain.proto.kpi.KPIValuesMessageRS.KPIValueMonth;
import me.bpulse.domain.proto.kpi.KPIValuesMessageRS.KPIValueSecond;
import me.bpulse.domain.proto.kpi.KPIValuesMessageRS.KPIValueYear;
import me.bpulse.domain.proto.kpi.KPIValuesMessageRS.KPIValuesRS;
import me.bpulse.domain.proto.kpi.KPIValuesMessageRS.Values;

import org.junit.Test;

/**
 * @author BPulse team
 * 
 * @Copyright (c) BPulse - http://www.bpulse.me
 */
public class KPIValuesMessageTest {

	@Test
	public void testNewInstanceRQ() {
		KPIValuesRQ.Builder rqBuilder = KPIValuesRQ.newBuilder();
		Range.Builder rgBuild = Range.newBuilder();
		rgBuild.setGte(1);
		rgBuild.setLte(20);

		WhereCondition.Builder wcBuil = WhereCondition.newBuilder();
		wcBuil.setTimeRange(rgBuild);

		rgBuild = Range.newBuilder();
		rgBuild.setGte(0);
		rgBuild.setLte(300000);
		wcBuil.setValueRange(rgBuild);

		Condition.Builder condition = Condition.newBuilder();
		condition.setAttName("clientId");
		condition.setValue("ACME");
		wcBuil.addConditions(condition);
		rqBuilder.setWhereCondition(wcBuil);

		rqBuilder.addGroupBy("clientId");

		KPIValuesRQ rq = rqBuilder.build();
		System.out.println(rq.toString());
	}

	@Test
	public void testNewInstanceRS() {
		KPIValuesRS.Builder rsBuilder = KPIValuesRS.newBuilder();
		rsBuilder.setId("KIP-ID");
		rsBuilder.setRsTime(200);
		rsBuilder.setShortName("Nombre Corto");

		Values.Builder values = Values.newBuilder();
		values.addGrpV("ACM");
		values.addGrpV("COL");
		values.addGrpV("BOOKING");

		KPIValueYear.Builder yBuild = KPIValueYear.newBuilder();
		yBuild.setY(2011);
		yBuild.setV(322000);

		KPIValueMonth.Builder month = null;
		for (int i = 1; i < 2; i++) {

			month = KPIValueMonth.newBuilder();
			month.setM(i);
			month.setV(3300);

			KPIValueDay.Builder day = null;
			for (int j = 1; i < 3; i++) {
				day = KPIValueDay.newBuilder();
				day.setD(j);
				day.setV(1501);

				KPIValueHour.Builder hour = null;
				for (int k = 1; k < 2; k++) {
					hour = KPIValueHour.newBuilder();
					hour.setH(k);
					hour.setV(122);

					KPIValueMinute.Builder minute = null;
					for (int l = 0; l < 3; l++) {
						minute = KPIValueMinute.newBuilder();
						minute.setMi(l);
						minute.setV(12);

						KPIValueSecond.Builder second = null;
						second = KPIValueSecond.newBuilder();
						second.setS(59);
						second.setV(1);
						minute.addSc(second);

						hour.addMts(minute);
					}
					day.addHs(hour);
				}
				month.addDs(day);
			}
			yBuild.addMs(month);
		}

		values.addYs(yBuild);
		rsBuilder.addGroupBy("client");
		rsBuilder.addGroupBy("country");
		rsBuilder.addGroupBy("operation");
		rsBuilder.addValues(values);

		System.out.println(rsBuilder.build().toString());
	}
}