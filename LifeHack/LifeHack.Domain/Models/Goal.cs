using Newtonsoft.Json;
using System.Collections.Generic;

namespace LifeHack.Domain.Models
{
    /// <summary>
    /// Encapsulates a Goal data transfer object.
    /// </summary>
    public class Goal : Entity
    {
        [JsonProperty("name")]
        public string Name { get; set; }
        [JsonProperty("sequence")]
        public int Sequence { get; set; }
        [JsonProperty("goals")]
        public List<Goal> Goals { get; set; }
    }
}
