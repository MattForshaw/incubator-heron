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


package org.apache.heron.api.bolt;

import java.util.List;

import org.apache.heron.api.tuple.Tuple;
import org.apache.heron.api.utils.Utils;


public class BasicOutputCollector implements IBasicOutputCollector {
  private OutputCollector out;
  private Tuple inputTuple;

  public BasicOutputCollector(OutputCollector output) {
    this.out = output;
  }

  public List<Integer> emit(String streamId, List<Object> tuple) {
    return out.emit(streamId, inputTuple, tuple);
  }

  public List<Integer> emit(List<Object> tuple) {
    return emit(Utils.DEFAULT_STREAM_ID, tuple);
  }

  public void setContext(Tuple anInputTuple) {
    this.inputTuple = anInputTuple;
  }

  public void emitDirect(int taskId, String streamId, List<Object> tuple) {
    out.emitDirect(taskId, streamId, inputTuple, tuple);
  }

  public void emitDirect(int taskId, List<Object> tuple) {
    emitDirect(taskId, Utils.DEFAULT_STREAM_ID, tuple);
  }

  protected IOutputCollector getOutputter() {
    return out;
  }

  public void reportError(Throwable t) {
    out.reportError(t);
  }
}
