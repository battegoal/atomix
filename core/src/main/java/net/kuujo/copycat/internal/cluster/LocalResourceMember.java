/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kuujo.copycat.internal.cluster;

import net.kuujo.copycat.CopycatContext;
import net.kuujo.copycat.cluster.LocalMember;
import net.kuujo.copycat.cluster.MessageHandler;
import net.kuujo.copycat.spi.ExecutionContext;

/**
 * Local resource member.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public class LocalResourceMember extends ResourceMember implements LocalMember {
  private final LocalMember member;

  public LocalResourceMember(LocalMember member, CopycatContext context, ExecutionContext executor) {
    super(member, context, executor);
    this.member = member;
  }

  @Override
  public <T, U> LocalMember registerHandler(String topic, MessageHandler<T, U> handler) {
    member.registerHandler(topic, handler);
    return this;
  }

  @Override
  public LocalMember unregisterHandler(String topic) {
    member.unregisterHandler(topic);
    return this;
  }

}
