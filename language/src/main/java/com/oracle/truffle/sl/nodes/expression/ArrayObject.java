package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.object.Shape;

@ExportLibrary(InteropLibrary.class)
public final class ArrayObject implements TruffleObject {
    public Shape shape;
    public Object[] arrayObjects;

    public ArrayObject(Shape shape, Object[] arrayObjects) {
        this.shape = shape;
        this.arrayObjects = arrayObjects;
    }

    @ExportMessage
    boolean hasArrayElements() {
        return true;
    }

    @ExportMessage
    Object readArrayElement(long index) {
        return arrayObjects[(int) index];
    }

    @ExportMessage
    long getArraySize() throws UnsupportedMessageException {
        return this.arrayObjects.length;
    }

    @ExportMessage
    boolean isArrayElementReadable(long index) {
        return true;
    }
}
