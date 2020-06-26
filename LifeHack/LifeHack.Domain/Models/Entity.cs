using Newtonsoft.Json;

namespace LifeHack.Domain.Models
{
    public class Entity
    {
        [JsonProperty("id")]
        public long Id { get; set; }
    }
}
