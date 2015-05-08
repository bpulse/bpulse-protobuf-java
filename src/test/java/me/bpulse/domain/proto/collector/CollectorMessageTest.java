/**
 *  @Copyright (c) BPulse - http://www.bpulse.me
 */
package me.bpulse.domain.proto.collector;

import static org.junit.Assert.*;
import me.bpulse.domain.proto.collector.CollectorMessageRQ.Pulse;
import me.bpulse.domain.proto.collector.CollectorMessageRQ.PulsesRQ;
import me.bpulse.domain.proto.collector.CollectorMessageRQ.Value;

import org.junit.Test;

/**
 * Clase de prueba de la generacion ProtoBuf del objeto CollectorMessage.
 * 
 * @author BPulse team
 * 
 * @Copyright (c) BPulse - http://www.bpulse.me
 */
public class CollectorMessageTest {

    @Test
    public void testNewInstance() {

	PulsesRQ.Builder pulsesBuilder = PulsesRQ.newBuilder();
	Pulse.Builder pulseBuilder = null;

	pulsesBuilder.setVersion("0.1");
	// Pulse de la lista de pulsos
	for (int k = 0; k < 1000; k++) {
	    pulseBuilder = Pulse.newBuilder();
	    pulseBuilder.setTypeId("TYPE");
	    pulseBuilder.setTime(19810710L);
	    pulseBuilder.setInstanceId(String.valueOf(k));

	    Value.Builder value = null;
	    // Valores del pulso
	    for (int i = 0; i < 10; i++) {
		value = Value.newBuilder();
		value.setName("valueName" + i);

		// grupo de valores del pulso
		value.addValues("value0");
		value.addValues("value1");

		// agrage un valor al pulso
		pulseBuilder.addValues(value);
	    }

	    pulsesBuilder.addPulse(pulseBuilder);
	}

	PulsesRQ pulses = pulsesBuilder.build();

	assertEquals("0.1", pulses.getVersion());

	java.util.List<Pulse> pulseList = pulses.getPulseList();
	assertNotNull(pulseList);
	assertEquals(1000, pulseList.size());

	for (Pulse p : pulseList) {
	    assertEquals("TYPE", p.getTypeId());
	    assertEquals(19810710L, p.getTime());

	    // Lista de valores
	    assertEquals(10, p.getValuesCount());
	    java.util.List<Value> values = p.getValuesList();

	    for (Value value : values) {
		assertTrue(value.getName().startsWith("valueName"));
		assertEquals(2, value.getValuesCount());

		assertEquals("value0", value.getValues(0));
		assertEquals("value1", value.getValues(1));
	    }
	}
    }
}
