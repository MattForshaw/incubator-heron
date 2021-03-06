// Copyright 2017 Twitter. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.heron.api.windowing;

import java.io.Serializable;

public class EventImpl<T extends Serializable> implements Event<T> {
  private static final long serialVersionUID = -6459336682025060065L;
  private final T event;
  private long ts;

  EventImpl(T event, long ts) {
    this.event = event;
    this.ts = ts;
  }

  @Override
  public long getTimestamp() {
    return ts;
  }

  @Override
  public T get() {
    return event;
  }

  @Override
  public boolean isWatermark() {
    return false;
  }

  @Override
  public String toString() {
    return "EventImpl{" + "event=" + event + ", ts=" + ts + '}';
  }
}
