# 4. Data Format Network Communication

Date: 2025-03-14

## Status

Accepted

## Context

Er moeten voor een gedistribueerde game die in Java ontwikkeld wordt game-events over het netwerk verstuurd worden. Een Java klasse kan niet zomaar over het netwerk verstuurd worden. Er moet bepaald worden welk dataformaat er gebruikt wordt om deze game-events over het netwerk te versturen.

## Considered Options

| Forces                                                | Java String als Byte-array | JSON | XML |
|-------------------------------------------------------|:--------------------------:|:----:|:---:|
| Bestaande APIs beschikbaar voor de serializatie       |             +              |  ++  | ++  |
| Zo weinig mogelijk overhead                           |             ++             |  -   | --  |
| Snelheid                                              |             0              |  ?   |  ?  |
| Netwerkdata mag niet direct leesbaar zijn voor mensen |             0              |  ++  | ++  |

## Decision

Het serialiseren van game-event resulteert in een string. Omdat alle informatie in het event opgeslagen staat, hoeft alleen deze string verstuurd te worden over het netwerk. Hierdoor is het mogelijk om een enkele bytestream over het netwerk te versturen zonder verdere informatie. XML en JSON maken het mogelijk om meerdere key-value paren te versturen. Omdat enkel de geserialiseerde string verstuurd hoeft te worden, heeft dit voor TunnelVision geen meerwaarde. Bovendien vergen deze dataformaten meer opslagruimte.

## Consequences

* Bij wijziging in de definitie van de klasse van het game-event, moet de serializatie van de klasse aangepast worden en moeten alle games geupdatet worden naar die versie.