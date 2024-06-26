/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.ikarabulut.energize.api.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class BatteryEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 9040507822997167123L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"BatteryEvent\",\"namespace\":\"com.ikarabulut.energize.api.avro\",\"fields\":[{\"name\":\"uuid\",\"type\":\"string\"},{\"name\":\"arrival_time_ms\",\"type\":[\"long\",\"null\"]},{\"name\":\"body\",\"type\":[\"bytes\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<BatteryEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<BatteryEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<BatteryEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<BatteryEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<BatteryEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this BatteryEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a BatteryEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a BatteryEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static BatteryEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence uuid;
  private java.lang.Long arrival_time_ms;
  private java.nio.ByteBuffer body;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public BatteryEvent() {}

  /**
   * All-args constructor.
   * @param uuid The new value for uuid
   * @param arrival_time_ms The new value for arrival_time_ms
   * @param body The new value for body
   */
  public BatteryEvent(java.lang.CharSequence uuid, java.lang.Long arrival_time_ms, java.nio.ByteBuffer body) {
    this.uuid = uuid;
    this.arrival_time_ms = arrival_time_ms;
    this.body = body;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return uuid;
    case 1: return arrival_time_ms;
    case 2: return body;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: uuid = (java.lang.CharSequence)value$; break;
    case 1: arrival_time_ms = (java.lang.Long)value$; break;
    case 2: body = (java.nio.ByteBuffer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'uuid' field.
   * @return The value of the 'uuid' field.
   */
  public java.lang.CharSequence getUuid() {
    return uuid;
  }


  /**
   * Sets the value of the 'uuid' field.
   * @param value the value to set.
   */
  public void setUuid(java.lang.CharSequence value) {
    this.uuid = value;
  }

  /**
   * Gets the value of the 'arrival_time_ms' field.
   * @return The value of the 'arrival_time_ms' field.
   */
  public java.lang.Long getArrivalTimeMs() {
    return arrival_time_ms;
  }


  /**
   * Sets the value of the 'arrival_time_ms' field.
   * @param value the value to set.
   */
  public void setArrivalTimeMs(java.lang.Long value) {
    this.arrival_time_ms = value;
  }

  /**
   * Gets the value of the 'body' field.
   * @return The value of the 'body' field.
   */
  public java.nio.ByteBuffer getBody() {
    return body;
  }


  /**
   * Sets the value of the 'body' field.
   * @param value the value to set.
   */
  public void setBody(java.nio.ByteBuffer value) {
    this.body = value;
  }

  /**
   * Creates a new BatteryEvent RecordBuilder.
   * @return A new BatteryEvent RecordBuilder
   */
  public static com.ikarabulut.energize.api.avro.BatteryEvent.Builder newBuilder() {
    return new com.ikarabulut.energize.api.avro.BatteryEvent.Builder();
  }

  /**
   * Creates a new BatteryEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new BatteryEvent RecordBuilder
   */
  public static com.ikarabulut.energize.api.avro.BatteryEvent.Builder newBuilder(com.ikarabulut.energize.api.avro.BatteryEvent.Builder other) {
    if (other == null) {
      return new com.ikarabulut.energize.api.avro.BatteryEvent.Builder();
    } else {
      return new com.ikarabulut.energize.api.avro.BatteryEvent.Builder(other);
    }
  }

  /**
   * Creates a new BatteryEvent RecordBuilder by copying an existing BatteryEvent instance.
   * @param other The existing instance to copy.
   * @return A new BatteryEvent RecordBuilder
   */
  public static com.ikarabulut.energize.api.avro.BatteryEvent.Builder newBuilder(com.ikarabulut.energize.api.avro.BatteryEvent other) {
    if (other == null) {
      return new com.ikarabulut.energize.api.avro.BatteryEvent.Builder();
    } else {
      return new com.ikarabulut.energize.api.avro.BatteryEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for BatteryEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<BatteryEvent>
    implements org.apache.avro.data.RecordBuilder<BatteryEvent> {

    private java.lang.CharSequence uuid;
    private java.lang.Long arrival_time_ms;
    private java.nio.ByteBuffer body;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.ikarabulut.energize.api.avro.BatteryEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.uuid)) {
        this.uuid = data().deepCopy(fields()[0].schema(), other.uuid);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.arrival_time_ms)) {
        this.arrival_time_ms = data().deepCopy(fields()[1].schema(), other.arrival_time_ms);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.body)) {
        this.body = data().deepCopy(fields()[2].schema(), other.body);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing BatteryEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.ikarabulut.energize.api.avro.BatteryEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.uuid)) {
        this.uuid = data().deepCopy(fields()[0].schema(), other.uuid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.arrival_time_ms)) {
        this.arrival_time_ms = data().deepCopy(fields()[1].schema(), other.arrival_time_ms);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.body)) {
        this.body = data().deepCopy(fields()[2].schema(), other.body);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'uuid' field.
      * @return The value.
      */
    public java.lang.CharSequence getUuid() {
      return uuid;
    }


    /**
      * Sets the value of the 'uuid' field.
      * @param value The value of 'uuid'.
      * @return This builder.
      */
    public com.ikarabulut.energize.api.avro.BatteryEvent.Builder setUuid(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.uuid = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'uuid' field has been set.
      * @return True if the 'uuid' field has been set, false otherwise.
      */
    public boolean hasUuid() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'uuid' field.
      * @return This builder.
      */
    public com.ikarabulut.energize.api.avro.BatteryEvent.Builder clearUuid() {
      uuid = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'arrival_time_ms' field.
      * @return The value.
      */
    public java.lang.Long getArrivalTimeMs() {
      return arrival_time_ms;
    }


    /**
      * Sets the value of the 'arrival_time_ms' field.
      * @param value The value of 'arrival_time_ms'.
      * @return This builder.
      */
    public com.ikarabulut.energize.api.avro.BatteryEvent.Builder setArrivalTimeMs(java.lang.Long value) {
      validate(fields()[1], value);
      this.arrival_time_ms = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'arrival_time_ms' field has been set.
      * @return True if the 'arrival_time_ms' field has been set, false otherwise.
      */
    public boolean hasArrivalTimeMs() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'arrival_time_ms' field.
      * @return This builder.
      */
    public com.ikarabulut.energize.api.avro.BatteryEvent.Builder clearArrivalTimeMs() {
      arrival_time_ms = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'body' field.
      * @return The value.
      */
    public java.nio.ByteBuffer getBody() {
      return body;
    }


    /**
      * Sets the value of the 'body' field.
      * @param value The value of 'body'.
      * @return This builder.
      */
    public com.ikarabulut.energize.api.avro.BatteryEvent.Builder setBody(java.nio.ByteBuffer value) {
      validate(fields()[2], value);
      this.body = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'body' field has been set.
      * @return True if the 'body' field has been set, false otherwise.
      */
    public boolean hasBody() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'body' field.
      * @return This builder.
      */
    public com.ikarabulut.energize.api.avro.BatteryEvent.Builder clearBody() {
      body = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public BatteryEvent build() {
      try {
        BatteryEvent record = new BatteryEvent();
        record.uuid = fieldSetFlags()[0] ? this.uuid : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.arrival_time_ms = fieldSetFlags()[1] ? this.arrival_time_ms : (java.lang.Long) defaultValue(fields()[1]);
        record.body = fieldSetFlags()[2] ? this.body : (java.nio.ByteBuffer) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<BatteryEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<BatteryEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<BatteryEvent>
    READER$ = (org.apache.avro.io.DatumReader<BatteryEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.uuid);

    if (this.arrival_time_ms == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeLong(this.arrival_time_ms);
    }

    if (this.body == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeBytes(this.body);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.uuid = in.readString(this.uuid instanceof Utf8 ? (Utf8)this.uuid : null);

      if (in.readIndex() != 0) {
        in.readNull();
        this.arrival_time_ms = null;
      } else {
        this.arrival_time_ms = in.readLong();
      }

      if (in.readIndex() != 0) {
        in.readNull();
        this.body = null;
      } else {
        this.body = in.readBytes(this.body);
      }

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.uuid = in.readString(this.uuid instanceof Utf8 ? (Utf8)this.uuid : null);
          break;

        case 1:
          if (in.readIndex() != 0) {
            in.readNull();
            this.arrival_time_ms = null;
          } else {
            this.arrival_time_ms = in.readLong();
          }
          break;

        case 2:
          if (in.readIndex() != 0) {
            in.readNull();
            this.body = null;
          } else {
            this.body = in.readBytes(this.body);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










