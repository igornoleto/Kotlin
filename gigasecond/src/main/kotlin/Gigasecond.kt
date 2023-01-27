import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(var localDate: LocalDateTime) {
    // TODO: Implement proper constructor
    constructor(localDate: LocalDate) : this(localDate.atStartOfDay())

    val date: LocalDateTime = localDate.plus(java.time.Duration.ofSeconds(1000000000))
}
