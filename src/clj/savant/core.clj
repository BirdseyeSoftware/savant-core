(ns savant.core)

(defprotocol IEventStream
  (get-rev-id [this])
  (tip? [this])
  (get-tip [this])
  (commit-events! [this events])
  (get-commits-seq [this])
  (get-events-seq
    [this]
    [this from-event-id]
    [this from-event-id to-event-id])
  (get-events-vec
    [this]
    [this from-event-id]
    [this from-event-id to-event-id])
  ; the commit can have clj meta attached to the events seq
  )

(defprotocol IEventStore
  (-same-store? [this other-store])
  (exists? [this bucket-name id])
  (create-stream [this bucket-name id])
  (get-stream
    [this bucket-name id]
    [this bucket-name id opts]))
